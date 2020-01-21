

function detail(){
    loadHome();
    var dat = document.cookie.split("=");
    //alert(dat[1]);
   
        $.get('PlayerDetails', {
            data : dat[1]
        }, function(responseText) {
           // e.preventDefault();

                 // alert(responseText);
                 // e.preventDefault();
                 //console.log(cookie);

                 // console.log(responseText);
             if(responseText.length>0 && responseText !== "null"){
                // console.log(responseText)
                        UIfunction(responseText);
                      }
              else{
                    alert(responseText);
                    window.location.replace("playerReg.html");
              }
        });
  
}

function UIfunction(details){
     var player = JSON.parse(details); 
     var fname = player.firstName;
     var lname = player.lastName;
     var fullname = fname+" "+lname;
     var email = player.email;
     var gender = player.gender;
     var team = player.team;
     var img = player.image;
     var phone = player.phone;
     var type = player.type;
     var ssize = player.shirtSize;
     var eid = player.empId;
     var age = player.age;
     var mpl = player.matchesPlayed;
     var pos = player.position;
     var bid = player.bidStatus;
     var role = player.role;
     var uid = player.userId;

    var card = document.createElement('div');
    card.setAttribute('class','card');

    var imgDiv = document.createElement('div');
    imgDiv.setAttribute('class','imgdiv');
    var image = document.createElement('img');
    image.setAttribute('src',img);
    image.setAttribute('class','userphoto');
    imgDiv.appendChild(image);
    
    var name = document.createElement('h1');
    name.textContent = fullname;

    var emailT = document.createElement('h4');
    emailT.textContent ="Email : " + email;

    var genderT = document.createElement('h4');
    genderT.textContent ="Gender : " + gender;


    var teamT = document.createElement('h4');
    if(team!=null)
    {
        teamT.textContent ="Team : " + team;
    }
    else
    {
        teamT.textContent = "Team : You will be in a Team soon!"
    }

    var typeT = document.createElement('h4');
    typeT.textContent ="Experice Level : " + type;
    var posT = document.createElement('h4');
    posT.setAttribute('class','position');
    if(pos==0 && mpl==0)
    {
        posT.textContent = "No Matches Played Yet!";
    }
    else
    {
        var pdiv = document.createElement('div');
        pdiv.setAttribute('id','pdiv');
        pdiv.innerText = "Your Position is "+pos;
        posT.textContent = pos;
    }

    if(mpl!=0)
    {
        var matchesT = document.createElement('h4');
        matchesT.textContent = "Matches Played : " + mpl;
    }

    card.appendChild(imgDiv);
    card.appendChild(posT);
    if(mpl>0)
    card.appendChild(pdiv);
    card.appendChild(name);
    if(mpl!=0)
    {
        card.appendChild(matchesT);
    }
    card.appendChild(emailT);
    card.appendChild(genderT);
    card.appendChild(typeT);

    var tdiv = document.createElement('div');
    tdiv.setAttribute('id','tdiv');
    var tbutton = document.createElement('input');
    tbutton.setAttribute('id','tbutton');
    tbutton.setAttribute('type','submit');
    tbutton.setAttribute('value','Create Tournament');
  //  tbutton.setAttribute('onclick','TournamentForm()')
   // tbutton.setAttribute('name',"Create Tournament");



    //document.body.appendChild(tdiv);
    tdiv.appendChild(tbutton);


    var container = document.createElement('div');
    container.setAttribute('class','cont');

    container.appendChild(card);
    container.appendChild(tdiv);

    document.body.appendChild(container);

}


function TournamentForm()
{
    var tndiv = document.createElement('div');
    tndiv.innerHTML =
    `
    <div id="id01" class="modal">
  
  <form class="modal-content animate"  method="post">
    <div class="container">
      <label for="trnName"><b>Tournament Name</b></label>
      <input type="text" placeholder="Enter Tournament" name="trnName" id="tnmae" required>

      <label for="trnLoc"><b>Tournament Location</b></label>
      <input type="text" placeholder="Enter Torunament Location" name="trnLoc" id="tloc" required>

      <label for="winPrize"><b>Winner Prize Money</b></label>
      <input type="text" placeholder="Enter Winner Prize Money" name="winPrize" id="twinp" required>

      <label for="runPrize"><b>Runner-up Prize Money</b></label>
      <input type="text" placeholder="Enter Runner Prize Money" name="runPrize" id="trunp" required>
        
      <button type="submit" id= "createtour" onclick="onclickF()">Create Tournament!</button>
      
    </div>

    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
      <span class="psw"> Your Role will be changed to Admin After creating Tournament</span>
    </div>
  </form>
</div>

    
 
    `

  document.body.appendChild(tndiv);

  //return tndiv;
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


$(document).on("click","#tbutton", function(){
  
   TournamentForm();
   document.getElementById('id01').style.display='block';
     

});

function onclickF(){

 

     var tourName = $('#tnmae').val();
     var tourLoc = $('#tloc').val();
     var tourWinP = $('#twinp').val();
     var tourRunP = $('#trunp').val();
    var email = document.cookie.split("=")[1];
        console.log("get method");
        alert("get method");
          $.post('CreateTournament', {
            trnName : tourName,
            tloc : tourLoc,
            twinp : tourWinP,
            trunp : tourRunP,
                  email : email
          }, function(responseText) {
                    alert(responseText);
                    //e.preventDefault();
                    console.log(responseText);

               if(responseText.includes("<html>") || responseText=="s"){

                      //alert("login");
                        window.location.replace("AdminDashboard.html");
                        var c = document.cookie.split(" ");
                        alert(c[0]);
                        alert(c[1]);
                        }
                else{
                      alert(responseText);
                      window.location.reload();
                }
               // return false
          });
   
    return false;
}