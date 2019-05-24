$(function () {

    var usernamerule = /^[a-zA-z]{5}$/;
    var userpasswordrule = /^[a-zA-Z]{5}$/;

    $("#username").blur(function () {
        var username = $("#username").val();
        var judge = usernamerule.test(username)
        if (judge == false){
            $(".form-group").addClass("has-error");
        }else {
            $(".form-group").removeClass("has-error");
        }
    })

    $("#userpassword").blur(function () {
        var userpassword = $("#userpassword").val();
        var judge = userpasswordrule.test(userpassword)
        if (judge == false){
            $(".form-group").addClass("has-error");
        }else {
            $(".form-group").removeClass("has-error");
        }
    })

    function check() {
        var username = $("#username").val();
        var userpassword = $("#userpassword").val();
        var judgename = usernamerule.test(username);
        var judgepassword = userpasswordrule.test(userpassword)
        if (judgename == true && judgepassword == true){
            return true;
        } else {
            return false;
        }
    }

        var random = [0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];
        var result = null;
        var s = "";
        for (var i = 0;i<4;i++){
            result = random[Math.floor(Math.random() * 36)];
            s += result;
        }
        $("#code").innerText=s;

})
