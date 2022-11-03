<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>

<head>
	<title>Destroydrop &raquo; Javascripts &raquo; Tree</title>
	<link rel="StyleSheet" href="/resources/css/dtree.css" type="text/css" />
	<script type="text/javascript" src="/resources/js/dtree.js"></script>
	<script type="text/javascript">
	$('#testTree').jstree({
		'core' : { "check_callback" :  true },
		'data' : treeList,
		'plugins' : ["dnd","contextmenu"]
	})
	</script>
</head>

<body>

<h1><a href="/">Destroydrop</a> &raquo; <a href="/javascripts/">Javascripts</a> &raquo; <a href="/javascripts/tree/">Tree</a></h1>

<h2>Example</h2>

<div class="testTree">

	<p><a href="javascript: d.openAll();">open all</a> | <a href="javascript: d.closeAll();">close all</a></p>

</div>

<p><a href="mailto&#58;drop&#64;destroydrop&#46;com">&copy;2002-2003 Geir Landr&ouml;</a></p>

</body>

</html>