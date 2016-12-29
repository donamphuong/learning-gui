package Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Operation {
    private String op = "", pre = "";

    public void calc() {
        JFrame frame1 = new JFrame("Calculator");
        frame1.setBounds(200, 300, 220, 350);

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(null);

        final JTextField txtid = new JTextField();
        txtid.setBounds(10, 10, 200, 50);
        frame1.add(txtid);
        txtid.setFont(new java.awt.Font("Lucida Grande", 0, 19));
        txtid.setHorizontalAlignment(JTextField.RIGHT);
        txtid.setText("0");
        txtid.disable();

        JButton a = new JButton("1");
        a.setBounds(10, 220, 50, 50);
        frame1.add(a);

        JButton b = new JButton("2");
        b.setBounds(60, 220, 50, 50);
        frame1.add(b);

        JButton c = new JButton("3");
        c.setBounds(110, 220, 50, 50);
        frame1.add(c);

        JButton d = new JButton ("4");
        d.setBounds(10,170,50,50);
        frame1.add(d);

        JButton e = new JButton ("5");
        e.setBounds(60,170,50,50);
        frame1.add(e);

        JButton f = new JButton ("6");
        f.setBounds(110,170,50,50);
        frame1.add(f);

        JButton g = new JButton ("7");
        g.setBounds(10,120,50,50);
        frame1.add(g);

        JButton h = new JButton ("8");
        h.setBounds(60,120,50,50);
        frame1.add(h);

        JButton i = new JButton ("9");
        i.setBounds(110,120,50,50);
        frame1.add(i);

        JButton j = new JButton ("0");
        j.setBounds(60,270,50,50);
        frame1.add(j);

        JButton k = new JButton ("+");
        k.setBounds(160,120,50,100);
        frame1.add(k);

        JButton l = new JButton ("-");
        l.setBounds(160,70,50,50);
        frame1.add(l);

        JButton m = new JButton ("*");
        m.setBounds(110,70,50,50);
        frame1.add(m);

        JButton n = new JButton ("/");
        n.setBounds(60,70,50,50);
        frame1.add(n);

        JButton o = new JButton ("=");
        o.setBounds(160,220,50,100);
        frame1.add(o);

        JButton p = new JButton (".");
        p.setBounds(110,270,50,50);
        frame1.add(p);

        JButton q = new JButton ("Del");
        q.setBounds(10,270,50,50);
        frame1.add(q);

        JButton r = new JButton ("AC");
        r.setBounds(10,70,50,50);
        frame1.add(r);

        frame1.setVisible(true);

        a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(op.equals("=")) {
                    txtid.setText("1");
                    op = "";
                } else if(txtid.getText().equals("0")) {
                    txtid.setText("1");
                } else {
                    txtid.setText("1" + txtid.getText());
                }
            }
        });

        b.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent ae){
                if(op.equals("=")){
                    txtid.setText("2");
                    op="";
                }
                else if(txtid.getText().equals("0"))
                    txtid.setText("2");
                else
                    txtid.setText(txtid.getText()+"2");
            }
        });

        c.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent ae){
                if(op.equals("=")){
                    txtid.setText("3");
                    op="";
                }
                else if(txtid.getText().equals("0"))
                    txtid.setText("3");
                else
                    txtid.setText(txtid.getText()+"3");
            }
        });

        d.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent ae){
                if(op.equals("=")){
                    txtid.setText("4");
                    op="";
                }
                else if(txtid.getText().equals("0"))
                    txtid.setText("4");
                else
                    txtid.setText(txtid.getText()+"4");
            }
        });

        e.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent ae){
                if(op.equals("=")){
                    txtid.setText("5");
                    op="";
                }
                else if(txtid.getText().equals("0"))
                    txtid.setText("5");
                else
                    txtid.setText(txtid.getText()+"5");
            }
        });

        f.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent ae){
                if(op.equals("=")){
                    txtid.setText("6");
                    op="";
                }
                else if(txtid.getText().equals("0"))
                    txtid.setText("6");
                else
                    txtid.setText(txtid.getText()+"6");
            }
        });

        g.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent ae){
                if(op.equals("=")){
                    txtid.setText("7");
                    op="";
                }
                else if(txtid.getText().equals("0"))
                    txtid.setText("7");
                else
                    txtid.setText(txtid.getText()+"7");
            }
        });

        h.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent ae){
                if(op.equals("=")){
                    txtid.setText("8");
                    op="";
                }
                else if(txtid.getText().equals("0"))
                    txtid.setText("8");
                else
                    txtid.setText(txtid.getText()+"8");
            }
        });

        i.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent ae){
                if(op.equals("=")){
                    txtid.setText("9");
                    op="";
                }
                else if(txtid.getText().equals("0"))
                    txtid.setText("9");
                else
                    txtid.setText(txtid.getText()+"9");
            }
        });


        j.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent ae){
                if(op.equals("=")){
                    txtid.setText("0");
                    op="";
                }
                else if(txtid.getText().equals("0"))
                    txtid.setText("0");
                else
                    txtid.setText(txtid.getText()+"0");
            }
        });

        k.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent ae){
                op="+";
                pre=txtid.getText();
                txtid.setText("");
            }
        });

        l.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent ae){
                op="-";
                pre=txtid.getText();
                txtid.setText("");
            }
        });

        m.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent ae){
                op="*";
                pre=txtid.getText();
                txtid.setText("");
            }
        });

        n.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent ae){
                op="/";
                pre=txtid.getText();
                txtid.setText("");
            }
        });

        p.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent ae){
                if(op.equals("=")){
                    txtid.setText("0.");
                    op="";
                }
                else
                    txtid.setText(txtid.getText()+".");
            }
        });

        q.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent ae){
                op="del";
                String str=txtid.getText();
                int p = str.length();
                if(p-1!=0)
                    txtid.setText(txtid.getText().substring(0,p-1));
                else
                    txtid.setText("0");
            }
        });

        r.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent ae){
                op="";  //AC
                pre=""; //AC
                txtid.setText("0");

            }
        });

        o.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (op) {
                    case "":
                        txtid.setText("0");
                        break;
                    case "+":
                        txtid.setText((Float.parseFloat(pre) + Float.parseFloat(txtid.getText())) + "");
                        break;
                    case "-":
                        txtid.setText((Float.parseFloat(pre)-Float.parseFloat(txtid.getText()))+"");
                        break;
                    case"*":
                        txtid.setText((Float.parseFloat(pre)*Float.parseFloat(txtid.getText()))+"");
                        break;
                    case"/":
                        txtid.setText((Float.parseFloat(pre)/Float.parseFloat(txtid.getText()))+"");
                        break;
                    case "=":
                        break;
                }
                op="=";
            }
        });
    }
}