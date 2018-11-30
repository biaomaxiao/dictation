function edit() {
    
}

function del() {
    
}

function play(baidu) {
    var f=function(i){
        setTimeout(function(){
            v=Things[i];
            var msg = new SpeechSynthesisUtterance(v);
            console.log(msg);
            window.speechSynthesis.speak(msg);
        },5000*i);
    };


    var a=baidu;
    Things = a.split('、');
    for (var i = 0; i < Things.length; i++) {
        f(i);
    }

}

function add() {
    
}