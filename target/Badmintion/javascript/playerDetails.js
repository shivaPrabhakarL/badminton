

function details(){
    var data = document.cookie;
    $(document).on("load", function(){
  
        $.get('AdminLogIn', {
            data : data
        }, function(responseTex,e) {
            e.p
                  alert(responseText);
                 // e.preventDefault();
                 console.log(cookie);

                  console.log(responseText);
             if(responseText.length>0){
                        card(responseText);
                      }
              else{
                    alert(responseText);
                    //window.location.replace("playerReg.html");
              }
        });
   });
}

function card(data){
    console.log(data);
}