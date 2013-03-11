package elementjava;

import com.uwyn.rife.engine.Element;

public class inheritance_parent extends Element
{
	public void processElement()
	{
		if (hasSubmission("activatechild"))
		{
			setOutput("trigger", "ok");
		}
		
		print("<html><body><a href=\""+getSubmissionQueryUrl("activatechild")+"\">activate child</a></body></html>");
	}
	
	public boolean childTriggered(String name, String[] values)
	{
		if (name.equals("trigger") &&
			values[0].equals("ok"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
