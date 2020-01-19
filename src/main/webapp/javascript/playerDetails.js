

function detail(){
    var dat = document.cookie.split("=");
    alert(dat[1]);
   
        $.get('AdminLogIn', {
            data : dat[1]
        }, function(responseText,e) {
           // e.preventDefault();

                  alert(responseText);
                 // e.preventDefault();
                 //console.log(cookie);

                 // console.log(responseText);
             if(responseText.length>0 && responseText !== "null"){
                // console.log(responseText)
                        UIfunction(responseText);
                      }
              else{
                    alert(responseText);
                    //window.location.replace("playerReg.html");
              }
        });
  
}

function UIfunction(details){
    console.log(details)
     const container = createTags('div','class', 'container');
     var email = details.email;
     var fname = details.firstName;
     var lname = details.lastName;
     console.log(details["email"]);
     console.log(fname);
     console.log(lname);
     appendChildToParent(main,container)
     const card = createTags('div','class', 'card')
     
     const imdiv = createTags('div','class','imdiv')

     const h2 = dataValidation(name,nullData,'h2','class','h2h3','h3','class','pnmae');

     const p = dataValidation(email,nullData,'p','class','ph3','p','class','pemail');

     const txtdiv = createTags('div','class','txtdiv');


     appendChildToParent(container,card)
     
     appendChildToParent(imdiv,imgVal)
     
     appendChildToParent(card,imdiv)
     
     appendChildToParent(txtdiv,h2)
     
     appendChildToParent(txtdiv,p)
     
     appendChildToParent(card,txtdiv);
}

function dataValidation(info,nullInfo,nullTag,nullSelector,nullSelectorName,noNullTag,noNullSelector,noNullSelectorName){
    if(info !== null){
        if(noNullTag === "img"){
            logo = createTags('img',noNullSelector,noNullSelectorName);
            logo.src = info;
            return logo;
        }
        if(noNullTag === "p"){
            pt = createTags('p')
            pt.textContent = info;
            return pt;

        }
        if(noNullTag === "h3"){
            h2t = createTags('h3');
            h2t.textContent = info;
            return h2t;
        }
    }       
    else{
            imgh3 =createTags(nullTag,nullSelector,nullSelectorName)
            imgh3.textContent=nullInfo;
            return imgh3;
    }
}

function appendChildToParent(parent,child){
    console.log(parent)
    return parent.appendChild(child);
}

function createTags(ele,selector,name){
    var tag = document.createElement(ele);
    if(selector){
        tag.setAttribute(selector,name);
    }
    return tag;

}

