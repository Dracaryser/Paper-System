function ine(data) {

    if (data == 1) {
        document.getElementById("checkTU").innerHTML = "<b style='color: red'>工号已存在</b>";
    } else if (data == 2) {
        document.getElementById("checkTU").innerHTML = "<b style='color:red'>工号不能为空</b>";
    } else if (data == 3) {
        document.getElementById("checkTU").innerHTML = "<b style='color:green'>该工号可用</b>"
    } else if (data == 0) {
        document.getElementById("checkTU").innerHTML = "<b style='color:red'>ajax成功返回值为空</b>"
    } else {
        document.getElementById("checkTU").innerHTML = "<b style='color:red'>未知错误</b>"
    }
}

function checkUser() {
    var tid = $('#tid').val();
    //var s = 0;
    $.ajax({
        type : "post",
        url : '/register/checkTutor',
        data : "tid=" + tid,
        success : function(data) {
            ine(data);
        }
    });

}

$(document).ready(function() {
    $("#tid").blur(function() {
        checkUser();
    });
})