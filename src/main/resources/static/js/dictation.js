//修改
function edit() {
    
}

//删除
/*function del(id) {
    alert("1");
    if (confirm("确定要删除吗?")) {
        $.ajax({
            url: "delWords",
            data: id,
            success: function (data) {
                if (data == true) {
                    window.location.href = "/";
                } else {
                    layer.msg("删除失败");
                }
            }
        })
    }
}*/

//播放
function play(id) {

    var state=document.getElementById("del_"+id).innerText;
    if(state=="已删除"){
        layer.msg("已删除，不可播放！");
        return;
    }
    var f=function(i){
        setTimeout(function(){
            v=Things[i];
            var msg = new SpeechSynthesisUtterance(v);
            console.log(msg);
            window.speechSynthesis.speak(msg);
        },2000*i);
    };
    //alert("t_"+id);
    var word=document.getElementById("t_"+id).innerText;
    Things = word.split(',');
    for (var i = 0; i < Things.length; i++) {
        f(i);
    }
}


function save() {
    if(confirm("确认提交吗?")){
        var input_word=$("#word").val();
        alert(input_word);
        if(!input_word){
            layer.msg("请输入单词");
            return false;
        }
        $.ajax({
            url:"addWords",
            data:{word:input_word},
            success:function (data) {
                if (data == "true") {
                    window.location.href = "/";
                } else {
                    layer.msg("删除失败");
                }
            }
        })
    }
}

