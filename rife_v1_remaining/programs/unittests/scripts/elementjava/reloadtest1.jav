package reloadscript;

import com.uwyn.rife.engine.Element;

public class scriptedjava extends Element
{
	public void processElement()
	{
		print("outer 1 : "+(new Inner().getOutput()));
	}
	
	class Inner
	{
		public Inner()
		{
		}
		
		public String getOutput()
		{
			return "reloadtest1";
		}
	}
}
