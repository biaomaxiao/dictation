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
        },5000*i);
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

//录入单词
function add() {
    layer.open({
        type: 1,
        skin: 'layui-layer-rim', //加上边框
        area: ['400px', '350px'], //宽高
        content: $("#add")
    });
    len = 1;
    $("#j").click(function () {
        $("#samp1").append('<input type="text" id="word"><br>');
        len += 1;
    });
    //多天记录添加
    $("#but").click(function () {
        var $inputArr = $('#add #word');//length = 3
        //循环处理input,并定义结果集
        var result = [];
        $inputArr.each(function () {
            //将每个input的值放进结果集
            result.push($(this).val());
        });
        //5.打印结果
        arr = result.join(",");
        $.ajax({
            url: "/addWords",
            data: {"word": arr},
            success: function (data) {
                if (data = true) {
                    alert("添加成功")
                    parent.window.location.reload();
                    var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                    parent.layer.close(index);
                }
            }
        })

    });
}

//删除
function del(id) {
    if (confirm("确定要删除吗?")) {
        $.ajax({
            url: "delWords",
            data: {id: id},
            success: function (data) {
                //alert(data);
                if (data == "true") {
                    window.location.href = "/";
                } else {
                    layer.msg("删除失败");
                }
            }
        })
    }
}

//修改提交
function edit(id) {
    $("#samp2").empty();
    layer.open({
        type: 1,
        skin: 'layui-layer-rim', //加上边框
        area: ['400px', '350px'], //宽高
        content: $("#updata")
    });
    $.ajax({
        url: "/allidWords",
        data: {id: id},
        success: function (data) {
            arr = data['word']
            a = arr.split(',');
            for (var i = 0; i < a.length; i++) {
                $(this).val("");
                $("#samp2").append('<input type="text" class="text" id="showdataid'+i+'"><br>');
                var pdid= "showdataid"+i;
                $("#" + pdid + "").val(a[i]);
            }
        }
    })

    $("#updataword").click(function () {
        var $inputArr = $('#updata .text');
        //循环处理input,并定义结果集
        var result = [];
        $inputArr.each(function () {
            //将每个input的值放进结果集
            result.push($(this).val());
        });
        //5.打印结果
        arr = result.join(",");
        $.ajax({
            url: "/updateWords",
            data: {"word": arr, "id": id},
            success: function (data) {
                if (data = true) {
                    alert("添加成功")
                    parent.window.location.reload();
                    var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                    parent.layer.close(index);
                }
            }
        })

    });

};


$("#updataword").click(function () {
    $.post(
        "/updateWords",
        {id: id},
        function (data) {
            alert("成功")
        },
        "json"
    );
});