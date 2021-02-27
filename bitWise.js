
function display(set,length){
    for(let bit=0;bit<length;bit++){
        if((set &(1<<bit))){
            console.log(bit+1)
        }
    }
}

var set=20

display(20,5)