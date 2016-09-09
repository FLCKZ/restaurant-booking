<?php

 define('HOST','localhost');
 define('USER','root');
 define('PASS','root');
 define('DB','flckzdb');

 
 $con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');
 if(!$con)
{

echo "Connection Error...".mysqli_connect_error();

}

else
{
echo "Database connection Success...";

}
 ?>