<?php
if(isset($_REQUEST['type']) && $_REQUEST['type']='create') {
	// create database and tables
   class MyDB extends SQLite3
   {
      function __construct()
      {
         $this->open('database.db');
      }
   }
   $db = new MyDB();
   if(!$db){
      echo $db->lastErrorMsg();
   } else {
      echo "Opened database successfully\n";
   }

   $sql =<<<EOF
      CREATE TABLE USERS
      (ID INT PRIMARY KEY ,username TEXT, password TEXT, fullname TEXT, mobileno TEXT, email TEXT);
EOF;

   $ret = $db->exec($sql);
   if(!$ret){
     /// echo $db->lastErrorMsg();
   } else {
     /// echo "Table created successfully\n";
   }
	
}
if(isset($_REQUEST['type']) && $_REQUEST['type']='register') {
	$username = $_REQUEST['username'];
	$password = $_REQUEST['password'];
	$fullname = $_REQUEST['fullname'];
	$mobileno = $_REQUEST['mobileno'];
	$email = $_REQUEST['email'];
	
	$ret = $db->exec("INSERT INTO USERS (username, password, fullname, mobileno, email) VALUES('$username', '$password', '$fullname', '$mobileno', '$email');");
	if($ret) echo "Inserted!<br>";
	$db->close();
}

if(isset($_REQUEST['type']) && $_REQUEST['type']='login') {
	echo "login function here";
	
}

else { echo "Shopping Server"; }

?>