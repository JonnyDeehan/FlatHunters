<html>
<body>
<h3>
What's your name? <br />
</h3>
<form action="test" method="GET" target="_blank">
<input type="text" name="first_name" />
<input type="text" name="last_name" />
<h3>
Which subjects do you like? <br />
</h3>
<input type="checkbox" name="math" /> Math
<input type="checkbox" name="physics"  /> Physics
<input type="checkbox" name="computer_science" checked="checked" /> Computer Science

<br />

<input type="submit" value="Select Subject" />
</form>
---------------------------------------------------------------------------------------------------------------<br />
<h3>
What's your name? <br />
</h3>
<form action="simple.jsp" method="GET">
<input type="text" name="first_name" />
<input type="text" name="last_name" />
<h3>
Which subjects do you like? <br />
</h3>
<input type="checkbox" name="math" /> Math
<input type="checkbox" name="physics"  /> Physics
<input type="checkbox" name="computer science" checked="checked" /> Computer Science

<br />

<input type="submit" value="Select Subject" />
</form>
</body>
</html>