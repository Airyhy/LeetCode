//Amazon

//find SSN numbers in a file that contains other information


//SSN: ^\d{3}-\d{2}-\d{4}$

//phone numbner: ^\d{3}-\d{3}-\d{4}$

//domain name: [\w\-]+(\.[\w\-]+)+

//html tag: <.+?>

//email: ^[\w!#$%&'*+/=?^_`{}~-]+@[\w\-]+(\.[\w\-]+)+$


//match whole string
public class regExpMatching{
	ssn.matches("^(\\d{3}-?\\d{2}-?\\d{4})$")

	//use regrex to match
	Pattern p=Pattern.compile("[a-z]");
	Matcher m=p.matcher(inputstring);
	if(m.find()){
		matcher.group();
	}
}