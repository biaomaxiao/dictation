function edit() {
    
}

function del() {
    
}

function play(id) {
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
    Things = word.split('、');
    for (var i = 0; i < Things.length; i++) {
        f(i);
    }
}

function add() {
    
}