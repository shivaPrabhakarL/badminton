function some(){
    loadHome();
    var liveupdateContainer = document.createElement('div');
    document.body.appendChild(liveupdateContainer);
    var matchno=document.createElement('p');
    matchno.textContent="Match no:";

    var matchnobox = document.createElement('input');
    matchnobox.setAttribute('type','text');

    var  ButtonM = document.createElement('input');
    ButtonM.setAttribute('type','submit');
    ButtonM.setAttribute('value','submit');

    liveupdateContainer.appendChild(matchno);
    matchno.appendChild(matchnobox);
    matchnobox.appendChild(ButtonM);

    var match=document.createElement('p');
    match.textContent="Match between";

    var dropdown=document.createElement('select');
    dropdown.setAttribute('class','dropbox');

    var option=document.createElement('option');
    option.textContent="select Team A";

    var option1=document.createElement('option');
    option1.textContent="Team 1";

    var option2=document.createElement('option');
    option2.textContent="Team 2";

    var option3=document.createElement('option');
    option3.textContent="Team 3";

    var option4=document.createElement('option');
    option4.textContent="Team 4";

    liveupdateContainer.appendChild(match);
    liveupdateContainer.appendChild(dropdown);
    dropdown.appendChild(option);
    dropdown.appendChild(option1);
    dropdown.appendChild(option2);
    dropdown.appendChild(option3);
    dropdown.appendChild(option4);

    var dropdown2=document.createElement('select');
    dropdown2.setAttribute('class','dropbox');

    var option_t=document.createElement('option');
    option_t.textContent="select Team B";

    var option_1=document.createElement('option');
    option_1.textContent="Team 1";

    var option_2=document.createElement('option');
    option_2.textContent="Team 2";

    var option_3=document.createElement('option');
    option_3.textContent="Team 3";

    var option_4=document.createElement('option');
    option_4.textContent="Team 4";

    liveupdateContainer.appendChild(dropdown2);
    dropdown2.appendChild(option_t);
    dropdown2.appendChild(option_1);
    dropdown2.appendChild(option_2);
    dropdown2.appendChild(option_3);
    dropdown2.appendChild(option_4);

    var players=document.createElement('p');
    players.textContent="select players";

    var dropdownp1=document.createElement('select');
    dropdownp1.setAttribute('class','dropbox');

    var option_pta=document.createElement('option');
    option_pta.textContent="select playerfrom Team A";

    var option1_pta=document.createElement('option');
    option1_pta.textContent="player 1";

    var option2_pta=document.createElement('option');
    option2_pta.textContent="player 2";

    var option3_pta=document.createElement('option');
    option3_pta.textContent="player 3";

    var option4_pta=document.createElement('option');
    option4_pta.textContent="player 4";

    liveupdateContainer.appendChild(players);
    liveupdateContainer.appendChild(dropdownp1);

    dropdownp1.appendChild(option_pta);
    dropdownp1.appendChild(option1_pta);
    dropdownp1.appendChild(option2_pta);
    dropdownp1.appendChild(option3_pta);
    dropdownp1.appendChild(option4_pta);


    var dropdownp2=document.createElement('select');
    dropdownp2.setAttribute('class','dropbox');

    var option_ptb=document.createElement('option');
    option_ptb.textContent="select playerfrom Team B";

    var option1_ptb=document.createElement('option');
    option1_ptb.textContent="player 1";

    var option2_ptb=document.createElement('option');
    option2_ptb.textContent="player 2";

    var option3_ptb=document.createElement('option');
    option3_ptb.textContent="player 3";

    var option4_ptb=document.createElement('option');
    option4_ptb.textContent="player 4";

    liveupdateContainer.appendChild(dropdownp2);
    dropdownp2.appendChild(option_ptb);
    dropdownp2.appendChild(option1_ptb);
    dropdownp2.appendChild(option2_ptb);
    dropdownp2.appendChild(option3_ptb);
    dropdownp2.appendChild(option4_ptb);

    var pointstable=document.createElement("div")
    pointstable.setAttribute('class','pointstable');
    pointstable.style.padding = "20px";

    var setLabel = document.createElement('label');
    setLabel.textContent = "set1 : ";

    var pointstext1 = document.createElement('input');
    pointstext1.setAttribute('type','text');

    var pointstext2 = document.createElement('input');
    pointstext2.setAttribute('type','text');
    pointstext2.style.margin = "20px";

    var pointstext3 = document.createElement('input');
    pointstext3.setAttribute('type','text');

    var  Button3 = document.createElement('input');
    Button3.setAttribute('type','submit');
    Button3.setAttribute('value','submit');

    document.body.appendChild(pointstable);
    pointstable.appendChild(setLabel);
    pointstable.appendChild(pointstext1);
    pointstable.appendChild(pointstext2);
    pointstable.appendChild(pointstext3);
    pointstable.appendChild(Button3);

    var pointstable2=document.createElement("div")
    pointstable2.setAttribute('class','pointstable2');
    pointstable2.style.padding = "20px";

    var setLabel2 = document.createElement('label');
    setLabel2.textContent = "set2 : ";

    var pointstext_1 = document.createElement('input');
    pointstext_1.setAttribute('type','text');

    var pointstext_2 = document.createElement('input');
    pointstext_2.setAttribute('type','text');
    pointstext_2.style.margin = "20px";

    var pointstext_3 = document.createElement('input');
    pointstext_3.setAttribute('type','text');

    var  Button2 = document.createElement('input');
    Button2.setAttribute('type','submit');
    Button2.setAttribute('value','submit');

    document.body.appendChild(pointstable2);
    pointstable2.appendChild(setLabel2);
    pointstable2.appendChild(pointstext_1);
    pointstable2.appendChild(pointstext_2);
    pointstable2.appendChild(pointstext_3);
    pointstable2.appendChild(Button2);

    var pointstable3=document.createElement("div");
    pointstable3.setAttribute('class','pointstable3');
    pointstable3.style.padding = "20px";

    var setLabel3 = document.createElement('label');
    setLabel3.textContent = "set3 : ";

    var pointstext1_1 = document.createElement('input');
    pointstext1_1.setAttribute('type','text');

    var pointstext1_2 = document.createElement('input');
    pointstext1_2.setAttribute('type','text');
    pointstext1_2.style.margin = "20px";

    var pointstext1_3 = document.createElement('input');
    pointstext1_3.setAttribute('type','text');

    var  signUpButton = document.createElement('input');
    signUpButton.setAttribute('type','submit');
    signUpButton.setAttribute('value','submit');

    document.body.appendChild(pointstable3);
    pointstable3.appendChild(setLabel3);
    pointstable3.appendChild(pointstext1_1);
    pointstable3.appendChild(pointstext1_2);
    pointstable3.appendChild(pointstext1_3);

    pointstable3.appendChild(signUpButton);
}