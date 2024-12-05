const element = document.querySelector('form');
element.addEventListener('submit', event => {
  event.preventDefault();
  // actual logic, e.g. validate the form
  console.log('Form submission cancelled.');
});

function myFunc(){

}

var x = document.getElementsByTagName('div');
for( let i = 0; i < x.length; i++){
    x[i].style.display = "none";
}

const allForms = document.querySelectorAll('form');

for( let i = 0; i < allForms.length; i++){
    const allDivs = allForms[i].querySelectorAll('div');
    allDivs[0].style.display = "block";
    for( let j = 1; j < allDivs.length; j++){
        if (allDivs[j].style.display === "none") {
            allDivs[j].style.display = "block";
            allDivs[j].addEventListener("click", myFunc());
          } else {
            allDivs[j].style.display = "none";
          }  
    }
}