//main div
var maindiv = document.createElement('div');
maindiv.setAttribute('class','main');
document.body.appendChild(maindiv);

//team  name
var teamName_div = document.createElement('div');
var setTeamName = document.createElement('label');
setTeamName.textContent = "Team Name : ";
setTeamName.setAttribute('class','text');
//textbox
var teamNameBox = document.createElement('input');
teamNameBox.setAttribute('type','text');
teamNameBox.setAttribute('id','Tname');
teamNameBox.setAttribute('class','textbox');


maindiv.appendChild(teamName_div);
teamName_div.appendChild(setTeamName);
teamName_div.appendChild(teamNameBox);


//button
var Button_div = document.createElement('div');
var setname=document.createElement('p');
    setname.setAttribute('class','text');
    setname.textContent="Add players";
var  Button = document.createElement('input');
Button.setAttribute('class','button');
Button.setAttribute('type','submit');
Button.setAttribute('value','+');

maindiv.appendChild(Button_div);
Button_div.appendChild(setname);
Button_div.appendChild(Button);
//submit button

var  submitButton = document.createElement('input');
submitButton.setAttribute('class','submitbutton');
submitButton.setAttribute('type','submit');
submitButton.setAttribute('value','submit');
submitButton.setAttribute('id','submitbtn');

Button_div.appendChild(submitButton);


var k = 1;
Button.onclick=function(){

    var selectingPlayers_div = document.createElement('div');


    var dropdown=document.createElement('select');
dropdown.setAttribute('class','dropbox');
dropdown.setAttribute('id','player'+String(k));
k++;

var option=document.createElement('option');
option.textContent="Select player";

var option1=document.createElement('option');
option1.textContent="player 1";

var option2=document.createElement('option');
option2.textContent="player 2";

var option3=document.createElement('option');
option3.textContent="player 3";

var option4=document.createElement('option');
option4.textContent="player 4";

maindiv.appendChild(selectingPlayers_div);

selectingPlayers_div.appendChild(dropdown);
dropdown.appendChild(option);
dropdown.appendChild(option1);
dropdown.appendChild(option2);
dropdown.appendChild(option3);
dropdown.appendChild(option4);

}



$(document).on("click","#submitbtn", function(){
    alert("hey");
    var k = 1;
    var id = String(k);
    var fid = '#player'+id;
    var arr = new Array();
    while($(fid).val()!=undefined)
    {
        if($(fid).val()!='Select player')
        {
        alert($(fid).val());
        arr.push($(fid).val())
        }
        k++;
        var id = String(k);
        var fid = '#player'+id;
    }
    alert(arr);
    arrayofPlayers = JSON.stringify(arr);
    alert(arrayofPlayers);
    var teamname = $('#Tname').val();

    $.post('AddTeam',{
        teamname : teamname,
        players : arrayofPlayers
       }, function(responseText){
           alert(responseText);
       });


    });

