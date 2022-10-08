import java.awt.*;
import java.awt.event.*;
class working_calc extends Frame implements ActionListener
{
	String val="";
	Panel t,c,e;
	Button bb1[]=new Button[12];
	Button bb2[]=new Button[3];
	Button bb3[]=new Button[3];
	TextField tf;
	Button b1,b2,b3,b4,b5,b6;
	working_calc ()
	{
		super("working calc");
		
		setSize(350,400);
		setVisible(true);
		setResizable(false);
		setEnabled(true);
		setLayout(new BorderLayout());
		Color cg=new Color(100,100,100);
		setBackground(cg);

		Panel t=new Panel();
		Color cc=new Color(100,100,100);
		t.setBackground(cc);
		tf=new TextField(30);
		tf.setText("0");
		t.add(tf);
		add(t,BorderLayout.NORTH);
		
		Panel b=new Panel();
		b.setLayout(new BorderLayout());

		
		Panel c=new Panel();
		c.setLayout(new GridLayout(4,3));
		String sb1[]={"7","8","9","4","5","6","1","2","3","0","00","."};
		for(int i=0;i<12;i++)
		{
			bb1[i]=new Button(sb1[i]);
			bb1[i].addActionListener(this);	
			c.add(bb1[i]);	
		}
		b.add(c,BorderLayout.CENTER);

		Panel e=new Panel();
		e.setLayout(new GridLayout(2,2));
		Panel e1=new Panel();
		e1.setLayout(new GridLayout(3,1));
		String sb2[]={"-","x","/"};
		for(int i=0;i<3;i++)
		{
			bb2[i]=new Button(sb2[i]);
			bb2[i].addActionListener(this);
			e1.add(bb2[i]);	
		}
		Panel e2=new Panel();
		e2.setLayout(new GridLayout(3,1));
		String sb3[]={"clear","dlt","%"};
		for(int i=0;i<3;i++)
		{
			bb3[i]=new Button(sb3[i]);
			bb3[i].addActionListener(this);
			e2.add(bb3[i]);	
		}
		b1=new Button("+");
		b1.addActionListener(this);
		b2=new Button("=");
		b2.addActionListener(this);
		e.add(e1);
		e.add(e2);
		e.add(b1);
		e.add(b2);
		b.add(e,BorderLayout.EAST);
		
		Panel n=new Panel();
		n.setLayout(new BorderLayout());
		n.setBackground(Color.black);
		b3=new Button("on/off");
		b3.addActionListener(this);
		n.add(b3,BorderLayout.EAST);
		b.add(n,BorderLayout.NORTH);

		add(b,BorderLayout.CENTER);
		show();
	}
	int n1,n2,l;
	String o="";
	String ss="";
	String s="";
	String s1="";
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			if(Integer.parseInt(ae.getActionCommand())>=0 &&Integer.parseInt(ae.getActionCommand())<=9||ae.getActionCommand()==".")
			{
				val=val+ae.getActionCommand();		
				tf.setText(val);
				//System.out.println(ae.getActionCommand());
			}
			//ss=val;
		}
		catch(Exception e)
		{	
			s=s+val;
			System.out.println(s+"##");
			String opr=ae.getActionCommand();
		 	if(opr.equals("+")||opr.equals("-")||opr.equals("x")||opr.equals("/"))
			{
				if(val.equals(""))
				{
					s=s+opr;
					val="0";
					tf.setText(opr);
					n1=0;
					val="";
				}
				else
				{
					s=s+opr;
					System.out.println(s+"##");
					tf.setText(opr);
					n1=Integer.parseInt(val);
					val="";
				}
				o=opr;
			}
			else if(opr.equals("%"))
			{
				n1=Integer.parseInt(val);
				s=val+opr;
				tf.setText(opr);
				 float n=n1/100;
				tf.setText(""+n);
				val="";
			}
			else if(opr.equals("clear"))
			{
				tf.setText("0");
				val="";
				s="";
			}
			else if(opr.equals("dlt"))
			{
				l=s.length();
				for(int i=0;i<l-1;i++)
				{
					s1=s1+s.charAt(i);
				}
				val="";
				s=s1;
				tf.setText(s);	
				s1="";	
			}
			else if(opr.equals("="))
			{	
				n2=Integer.parseInt(val);
				int a=set(	n1,n2,o);
				tf.setText(""+a);
				val=""+a;
				s="";
			}	
		}
	}
	int set(int n1,int n2,String o) 
	{
		int a=0;
		if(o.equals("+"))
		{
			a=n1+n2;
		}
		else if(o.equals("/"))
		{
			a=n1/n2;
			
		}					
		else if(o.equals("x"))
		{
			a=n1*n2;
		}					
		else if(o.equals("-"))
		{
			a=n1-n2;
		}
		return(a);				
					
	}
	public static void main(String a[])
	{
		new working_calc();
	}
}
