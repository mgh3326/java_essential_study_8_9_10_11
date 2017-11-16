package test;

import javax.swing.*;
import java.awt.event.*;;
import java.awt.*;
public class Four extends JFrame {
    Container c;
    JCheckBox b1 = new JCheckBox("버튼 비활성화");//버튼비활성화 체크박스 생성
    JCheckBox b2 = new JCheckBox("버튼 감추기");//버튼감추기 체크박스 생성
    JButton b = new JButton("test button");

    Four(){
        setTitle("CheckBox와 Item..");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = getContentPane();
        c.setLayout(new FlowLayout());
        //컴포넌트 생성, 컨텐트팬에 삽입, Item리스너 등록
        MyItemListener listener = new MyItemListener();
        b1.addItemListener(new MyItemListener());
        b2.addItemListener(new MyItemListener());
        c.add(b1);
        c.add(b2);
        c.add(b);
        setSize(250,200);
        setVisible(true);
    }
    //Item리스너 구현
    class MyItemListener implements ItemListener{
        boolean bool = true;
        //체크박스 선택 상태가 변하면 Change()호출
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange()==ItemEvent.SELECTED)bool=false;
            else bool= true;
            if(e.getItem()==b1)b.setEnabled(bool);
            else b.setVisible(bool);
        }
    }

    public static void main(String[] args) {
        new Four();
    }
}