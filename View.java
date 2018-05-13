package fattar;

import JavaSwings;

public class View {
    private JFrame myFrame;
    private JTextField myTextField;
    private JButton[] myButtons;

    View(){
        //myFrame, myTextField 등 UI element들을 생성 및 초기 값 설정해 줌.
    }

    private void actionListener(ActionEvent event){
        Controller.function();
    }
    
}