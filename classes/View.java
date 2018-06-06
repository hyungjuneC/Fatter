package fattar;

import JavaSwings;

public class View {
    private JFrame myFrame;
    private JTextField myTextField;
    private JButton[] myButtons;

    View(){
        //myFrame, myTextField 등 UI element들을 생성 및 초기 값 설정해 줌.
    }
    
    makeLoginUI(){      // login과 관련된 UI
        //myFrame, myTextField 등 UI element들을 생성 및 초기 값 설정해 줌.
    }
    makeAlarmUI(){      // alarm과 관련된 UI
         //myFrame, myTextField 등 UI element들을 생성 및 초기 값 설정해 줌.
    }
    maekGraphUI(){      // Graph와 관련된 UI
        //myFrame, myTextField 등 UI element들을 생성 및 초기 값 설정해 줌.
    }

    private void actionListener(ActionEvent event){
        Controller.function();
    }
    
}
