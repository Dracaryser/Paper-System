function ine(data) {

    if (data == 1) {
        document.getElementById("checkUN").innerHTML = "<b style='color: red'>学号已存在</b>";
    } else if (data == 2) {
        document.getElementById("checkUN").innerHTML = "<b style='color:red'>学号不能为空</b>";
    } else if (data == 3) {
        document.getElementById("checkUN").innerHTML = "<b style='color:green'>该学号可用</b>"
    } else if (data == 0) {
        document.getElementById("checkUN").innerHTML = "<b style='color:red'>ajax成功返回值为空</b>"
    } else {
        document.getElementById("checkUN").innerHTML = "<b style='color:red'>未知错误</b>"
    }
}

function checkUser() {
    var sid = $('#sid').val();
    //var s = 0;
    $.ajax({
        type : "post",
        url : '/register/check',
        data : "sid=" + sid,
        success : function(data) {
            ine(data);
        }
    });

}

$(document).ready(function() {
    $("#sid").blur(function() {
        checkUser();
    });
})