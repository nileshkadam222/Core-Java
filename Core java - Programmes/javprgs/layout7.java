import javax.swing.*;
import java.awt.*;
//<applet code="layout7" width=300 height=100> </applet> 


public class layout7 extends JApplet
{
	//Variables for the controls 
	JPanel panelObject;
	JLabel labeltitle, labelName, labelGrade, labelPerfCriteria, labelRating;
	JLabel line1,line2, line3;
	JTextField textName;
	JRadioButton buttonGrade1,buttonGrade2;
	JComboBox comboPerfCriteria;
	JList listRating;
	GridBagLayout gl;
	GridBagConstraints gbc;
	
	public void init()
	{
		//initialise the layout
		gl = new GridBagLayout();
		gbc = new GridBagConstraints();
		panelObject = (JPanel)getContentPane();
		panelObject.setLayout(gl);
            
		//initialise the controls
           labeltitle=new JLabel("Customer Care Executive Performance Sheet");
		line1=new JLabel("----------------------------------------------------------");
		labelName=new JLabel("Name :");
		labelGrade=new JLabel("Grade :");
		labelPerfCriteria=new JLabel("Performance Criteria");
		labelRating=new JLabel("Rating");
		line2=new JLabel("------------------------------");
		line3=new JLabel("-----------");
		
		textName=new JTextField(10);
		textName.setText("Carol");
		
		buttonGrade1=new JRadioButton("L1");
		buttonGrade2=new JRadioButton("L2");
 
		String criteria[] = {"Customer Satisfaction", "Productivity"};
		comboPerfCriteria = new JComboBox(criteria);

		String rating[]={"Outstanding","Excellent","Good","Poor"};
		listRating=new JList(rating);
          
		//Apply constraints and add controls to the panel
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 3;
		gbc.gridy = 1;
		gl.setConstraints(labeltitle,gbc);
		panelObject.add(labeltitle);
	        
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 3;
		gbc.gridy = 3;
		gl.setConstraints(line1,gbc);
		panelObject.add(line1);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 2;
		gbc.gridy = 9;
		gl.setConstraints(labelName,gbc);
		panelObject.add(labelName);
	        
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 9;
		gl.setConstraints(textName,gbc);
		panelObject.add(textName);
	
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 2;
		gbc.gridy = 14;
		gl.setConstraints(labelGrade,gbc);
		panelObject.add(labelGrade);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 14;
		gl.setConstraints(buttonGrade1,gbc);
		panelObject.add(buttonGrade1);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 5;
		gbc.gridy = 14;
		gl.setConstraints(buttonGrade2,gbc);
		panelObject.add(buttonGrade2);
	
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 2;
		gbc.gridy = 19;
		gl.setConstraints(labelPerfCriteria,gbc);
		panelObject.add(labelPerfCriteria);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 19;
		gl.setConstraints(labelRating,gbc);
		panelObject.add(labelRating);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 2;
		gbc.gridy = 22;
		gl.setConstraints(line2,gbc);
		panelObject.add(line2);
		
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 22;
		gl.setConstraints(line3,gbc);
		panelObject.add(line3);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 2;
		gbc.gridy = 26;
		gl.setConstraints(comboPerfCriteria,gbc);
		panelObject.add(comboPerfCriteria);
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 26;
		gl.setConstraints(listRating,gbc);
		panelObject.add(listRating);

	}
}
