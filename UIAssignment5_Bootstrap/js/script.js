const toggleSidebar = () =>{
    document.querySelector('body').classList.toggle("collapsed");
    console.log("working");
}

const project_chart = document.getElementById('project-graph');

new Chart(
    project_chart,
    {
        type: 'doughnut',
        data: {
            labels: [
              'Completed',
              'In-progress',
              'Behind'
            ],
            datasets: [{
              data: [64, 26, 10],
              backgroundColor: [
                'rgb(10, 207, 151)',
                'rgb(54, 162, 235)',
                'rgb(255, 99, 132)'
              ],
              hoverOffset: 4
            }]
          }
    }
)