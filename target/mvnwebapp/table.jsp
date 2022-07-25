<html>
<head>
    <title>Title</title>
    <script src="./js/jquery-1.11.0.min.js"></script>
    <script>
        $(document).ready(function (){
            //初始化数据
            initial();
            alert(222)
        });
        function initial(){
            $.post("/mvnwebapp_war_exploded/user.do",'',function(data){
               alert(111);
            },"json");
        }
    </script>
</head>
<body>
666
</body>
</html>
