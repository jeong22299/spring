<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>

<head>
<title>Destroydrop &raquo; Javascripts &raquo; Tree</title>

<link rel="StyleSheet" href="/resources/css/dtree.css" type="text/css" />
<script type="text/javascript" src="/resources/js/dtree.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/jstree.min.js"></script>
<script type="text/javascript">
$('#kt_docs_jstree_basic').jstree({
    "core" : {
        "themes" : {
            "responsive": false
        }
    },
    "types" : {
        "default" : {
            "icon" : "fa fa-folder"
        },
        "file" : {
            "icon" : "fa fa-file"
        }
    },
    "plugins": ["wholerow"]
});
$(function () {
	  $("#kt_docs_jstree_basic").jstree({
	    "plugins" : [ "search" ]
	  });
	  var to = false;
	  $('#plugins4_q').keyup(function () {
	    if(to) { clearTimeout(to); }
	    to = setTimeout(function () {
	      var v = $('#plugins4_q').val();
	      $('#plugins4').jstree(true).search(v);
	    }, 250);
	  });
	});
</script>
</head>

<body>

<h1><a href="/">Destroydrop</a> &raquo; <a href="/javascripts/">Javascripts</a> &raquo; <a href="/javascripts/tree/">Tree</a></h1>

<h2>Example</h2>

<div id="kt_docs_jstree_basic">
    <ul>
        <li>
            Root node 1
            <ul>
                <li data-jstree='{ "selected" : true }'>
                    <a href="javascript:;">
                        Initially selected </a>
                </li>
                <li data-jstree='{ "icon" : "flaticon2-gear text-success " }'>
                    custom icon URL
                </li>
                <li data-jstree='{ "opened" : true }'>
                    initially open
                    <ul>
                        <li data-jstree='{ "disabled" : true }'>
                            Disabled Node
                        </li>
                        <li data-jstree='{ "type" : "file" }'>
                            Another node
                        </li>
                    </ul>
                </li>
                <li data-jstree='{ "icon" : "flaticon2-rectangular text-danger" }'>
                    Custom icon class (bootstrap)
                </li>
            </ul>
        </li>
        <li data-jstree='{ "type" : "file" }'>
            <a href="http://www.keenthemes.com">
                Clickable link node </a>
        </li>
    </ul>
</div>


<p><a href="mailto&#58;drop&#64;destroydrop&#46;com">&copy;2002-2003 Geir Landr&ouml;</a></p>

</body>

</html>