if element.hasSubmission("login"):
	element.print(element.getParameter("login")+","+element.getParameter("password"))
else:
	if element.getInput("input1") == "form":
		element.print("<html><body>\n")
		element.print("<form action=\""+element.getSubmissionQueryUrl("login").toString()+"\" method=\"post\">\n")
		element.print("<input name=\"login\" type=\"text\">\n")
		element.print("<input name=\"password\" type=\"password\">\n")
		element.print("<input type=\"submit\">\n")
		element.print("</form>\n")
		element.print("</body></html>\n")
	else:
		element.print(element.getInput("input1")+","+element.getInput("input2"))
