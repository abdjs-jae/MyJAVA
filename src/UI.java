import myjava.antlrgen.MyJAVABaseListener;
import myjava.antlrgen.MyJAVALexer;
import myjava.antlrgen.MyJAVAParser;
import myjava.error.ErrorListener;
import myjava.error.MyJAVAErrorStrategy;
import myjava.execution.ExecutionManager;
import myjava.execution.FunctionTracker;
import myjava.semantics.analyzers.MainAnalyzer;
import myjava.semantics.statements.StatementControlOverseer;
import myjava.semantics.symboltable.SymbolTableManager;
import myjava.semantics.symboltable.scopes.LocalScopeCreator;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.fife.ui.autocomplete.AutoCompletion;
import org.fife.ui.autocomplete.BasicCompletion;
import org.fife.ui.autocomplete.CompletionProvider;
import org.fife.ui.autocomplete.DefaultCompletionProvider;
import uicomp.LinePainter;
import uicomp.SquigglePainter;
import uicomp.TextLineNumber;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by jasonsapdos on 06/10/2017.
 */
public class UI {

    // UI ELEMENTS

    private JPanel mainPane;
    private JTextArea txtArCode;
    private JPanel actionPane;
    private JScrollPane codePane;
    private JScrollPane consolePane;
    private JButton btnRun;
    private JButton btnClear;
    private JList consoleList;
    private JPanel codeCasePane;
    private JTabbedPane consoleTabPane;
    private JPanel allTab;
    private JPanel verboseTab;
    private JPanel errorTab;
    private JPanel debugTab;
    public DefaultListModel consoleListModel;

    // INPUT ELEMENTS
    private String code;
    private int lineNum;
    private ArrayList<Integer> errorPositionList;
    private int selectedTabIndex = 0;

    public UI() {

        // Highlights the line currently beign typed on
        LinePainter painter = new LinePainter(txtArCode);
        // Adds the line numbers on the side of the textarea
        TextLineNumber tln = new TextLineNumber(txtArCode);
        tln.setFont(new Font("Mono", Font.PLAIN, 12));
        codePane.setRowHeaderView( tln );
        implementAutoComplete();
        addListeners();
        initializeInterpreter();

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MyJAVA Interpreter");
        frame.setContentPane(new UI().mainPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void addListeners(){
        btnRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Run button clicked!");
                code = "public class Main { " + txtArCode.getText() + " }";
                removeHighlights(txtArCode);

                ErrorListener.clearLog();

                MyJAVALexer lex = new MyJAVALexer(new ANTLRInputStream(code));
                CommonTokenStream tokens = new CommonTokenStream(lex);
                MyJAVAParser parser = new MyJAVAParser(tokens);
                ErrorListener errorListener = new ErrorListener();
                parser.setErrorHandler(new MyJAVAErrorStrategy());
                parser.removeErrorListeners();
                parser.addErrorListener(errorListener);
                parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);

                ParserRuleContext parserRuleContext = parser.compilationUnit();
                ParseTreeWalker treeWalker = new ParseTreeWalker();
                treeWalker.walk(new MyJAVABaseListener(), parserRuleContext);

                // After semantic checking
                ExecutionManager.getExecutionManager().executeAllActions();

                // changed parse tree to method declaration context for the analyzing later on (context kinukuha ng analyzing)
                // MyJAVAParser.MethodDeclarationContext parserRuleContext = parser.methodDeclaration();
                //txtWriter.writeMessage(StringUtils.formatDebug(parserRuleContext.toStringTree(parser)));

                /*
                // main analyzer checks yung current stuff

                // brute-forced print command - initialize and place the print statement rule
                // then executes the print command
                PrintCommand printCommand = new PrintCommand(parserRuleContext.methodBody().block().blockStatement(0).statement().printStatement());
                printCommand.execute();
                */
                /*
                for(int ctr = 0; ctr < allTokens.size(); ctr++) {

                    Token t = allTokens.get(ctr);

                    String line[] = t.toString().split(",<");
                    String word[] = line[1].split(">");
                    int index = Integer.parseInt(word[0]);

                    String token = parser.getVocabulary().getDisplayName(index);
                    System.out.println(token);

                }
                */
                consoleListModel = new DefaultListModel();
                consoleList.setSelectedIndex(0);
                consoleListModel = errorListener.getConsoleListModel();
                errorPositionList = errorListener.getErrorPositionList();
                underlineErrors(errorPositionList);

                if(consoleListModel.getSize() == 0){
                    consoleListModel.addElement("[DEBUG] No syntax errors were detected.");
                }

                switch(consoleTabPane.getSelectedIndex()){
                    case 0: consoleList.setModel(generateDListModel(consoleListModel, 'A')); break;
                    case 1: consoleList.setModel(generateDListModel(consoleListModel, 'P')); break;
                    case 2: consoleList.setModel(generateDListModel(consoleListModel, 'E')); break;
                    case 3: consoleList.setModel(generateDListModel(consoleListModel, 'D')); break;
                }

                consolePane.setViewportView(consoleList);
                consoleList.setLayoutOrientation(JList.VERTICAL);
            }
        });
        consoleList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {

                    if(consoleList.getSelectedIndex() != -1) {
                        System.out.println(consoleList.getSelectedIndex());
                        String selectedMessage = consoleList.getSelectedValue().toString();

                        // Checks if message has an error keyword and contains a line number
                        if (selectedMessage.charAt(1) == 'E' && selectedMessage.contains("Line")) {
                            // Get the line number of the selected message!
                            lineNum = extractLineNumber(selectedMessage);
                            // Moves the highlight text to the line + 1
                            txtArCode.setCaretPosition(txtArCode.getDocument()
                                    .getDefaultRootElement().getElement(lineNum - 1)
                                    .getStartOffset());
                        }
                    }
                }
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                code = "";
                txtArCode.setText("");
                consolePane.getViewport().removeAll();
                consolePane.revalidate();
                consolePane.repaint();
            }
        });
        consoleTabPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(consoleListModel != null) {
                    System.out.println("Current tab: " + consoleTabPane.getSelectedIndex());
                    JScrollPane newPane = consolePane;
                    JList newList = (JList) newPane.getViewport().getView();

                    // Clear the consolePane of the last selected tab
                    ((JPanel) consoleTabPane.getComponentAt(selectedTabIndex)).removeAll();

                    switch (consoleTabPane.getSelectedIndex()) {
                        case 0: { // ALL
                            consoleList.setModel(consoleListModel);
                            allTab.add(consolePane);
                        }
                        break;
                        case 1: { // Program output
                            consoleList.setModel(generateDListModel(consoleListModel, 'P'));
                            verboseTab.add(newPane);
                        }
                        break;
                        case 2: { // Error
                            consoleList.setModel(generateDListModel(consoleListModel, 'E'));
                            errorTab.add(newPane);
                        }
                        break;
                        case 3: { // Debug
                            consoleList.setModel(generateDListModel(consoleListModel, 'D'));
                            debugTab.add(newPane);
                        }
                        break;
                    }
                    selectedTabIndex = consoleTabPane.getSelectedIndex();
                }
            }
        });
    }

    private DefaultListModel generateDListModel(DefaultListModel defaultListModel, char messageType){

        // No need to be filtered, all messages needed.
        if(messageType == 'A')
            return defaultListModel;

        DefaultListModel newModel = new DefaultListModel();

        for(int i = 0; i < defaultListModel.getSize(); i++){
            // if message does not contain the required type
            if(defaultListModel.get(i).toString().charAt(1) == messageType)
                newModel.addElement(defaultListModel.get(i));
        }

        System.out.println("newModel size: " + newModel.getSize());

        if(newModel.getSize() == 0)
            newModel.addElement("No messages of this type.");

        return newModel;
    }

    // Gets the line number from a message!
    private int extractLineNumber(String s){
        // [ERROR] Line 1:2
        String colonSplit = s.split("\\:")[0];
        // [ERROR] Line 1
        String smallESplit = colonSplit.substring(13, colonSplit.length());
        return Integer.parseInt(smallESplit);
    }

    private void underlineErrors(ArrayList<Integer> errorPositionList){
        SquigglePainter red = new SquigglePainter( Color.RED );

        for(int i = 0; i < errorPositionList.size(); i+=3){

            try {
                txtArCode.getHighlighter().addHighlight(errorPositionList.get(i+1),
                                                    errorPositionList.get(i+2)+1,
                                                        red);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }

    private static void removeHighlights(JTextComponent textComp) {
        Highlighter hilite = textComp.getHighlighter();
        Highlighter.Highlight[] hilites = hilite.getHighlights();

        for (Highlighter.Highlight hilite1 : hilites) {
            if (hilite1.getPainter() instanceof SquigglePainter) {
                hilite.removeHighlight(hilite1);
            }
        }
    }


    private void initializeInterpreter() {
        // Initialize the interpreter stuff
        SymbolTableManager.initialize();
        ExecutionManager.initialize();
        LocalScopeCreator.initialize();
        StatementControlOverseer.initialize();
        FunctionTracker.initialize();

        // Execution manager takes charge of thread
    }

    public static void resetComponents() {
        ExecutionManager.reset();
        LocalScopeCreator.reset();
        SymbolTableManager.reset();
        StatementControlOverseer.reset();
        FunctionTracker.reset();
    }

    private void implementAutoComplete(){
        // A CompletionProvider is what knows of all possible completions, and
        // analyzes the contents of the text area at the caret position to
        // determine what completion choices should be presented. Most instances
        // of CompletionProvider (such as DefaultCompletionProvider) are designed
        // so that they can be shared among multiple text components.
        CompletionProvider provider = createCompletionProvider();

        // An AutoCompletion acts as a "middle-man" between a text component
        // and a CompletionProvider. It manages any options associated with
        // the auto-completion (the popup trigger key, whether to display a
        // documentation window along with completion choices, etc.). Unlike
        // CompletionProviders, instances of AutoCompletion cannot be shared
        // among multiple text components.
        AutoCompletion ac = new AutoCompletion(provider);
        ac.install(txtArCode);
    }

    /*
     * Create a simple provider that adds some Java-related completions.
     */
    private CompletionProvider createCompletionProvider() {

        // A DefaultCompletionProvider is the simplest concrete implementation
        // of CompletionProvider. This provider has no understanding of
        // language semantics. It simply checks the text entered up to the
        // caret position for a match against known completions. This is all
        // that is needed in the majority of cases.
        DefaultCompletionProvider provider = new DefaultCompletionProvider();

        // Add completions for all Java keywords. A BasicCompletion is just
        // a straightforward word completion.
        // lower case
        provider.addCompletion(new BasicCompletion(provider, "break"));
        provider.addCompletion(new BasicCompletion(provider, "case"));
        // ... etc ...
        provider.addCompletion(new BasicCompletion(provider, "try"));
        provider.addCompletion(new BasicCompletion(provider, "void"));
        provider.addCompletion(new BasicCompletion(provider, "while"));

        // UPPER CASE
        provider.addCompletion(new BasicCompletion(provider, "BREAK"));
        provider.addCompletion(new BasicCompletion(provider, "CASE"));
        // ... etc ...
        provider.addCompletion(new BasicCompletion(provider, "TRY"));
        provider.addCompletion(new BasicCompletion(provider, "VOID"));
        provider.addCompletion(new BasicCompletion(provider, "WHILE"));

        // Add a couple of "shorthand" completions. These completions don't
        // require the input text to be the same thing as the replacement text.
            /*
            provider.addCompletion(new ShorthandCompletion(provider, "print",
                    "print(", print("));
            provider.addCompletion(new ShorthandCompletion(provider, "scan",
                    "scan(", "scan("));
            */

        return provider;

    }

}

