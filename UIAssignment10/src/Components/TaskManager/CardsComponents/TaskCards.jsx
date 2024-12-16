import React, { useEffect, useState } from "react";

function TaskCards({ tasks, taskType, showUpdateModal, deleteTask }) {
  
  const priorityColor = {
    "High" : "danger",
    "Medium" : "warning",
    "Low" : "success"
  }
  const [bgColorType, setbgColorType] = useState({});

  useEffect(() => {
    const cardBgColor = {
      New: {
        High: "#a6ceff",
        Medium: "#a6ceffa8",
        Low: "#a6ceff63",
      },
      "In Progress": {
        High: "#ffc3c3",
        Medium: "#ffc3c3a8",
        Low: "#ffc3c363",
      },
      Completed: {
        High: "#afebeb",
        Medium: "#afebeba8",
        Low: "#afebeb63",
      },
    };
    setbgColorType(cardBgColor[taskType]);
  }, [tasks, taskType]);

  return (
    <div className="cardDiv">
      <h6 className="text-center position-sticky top-0">{taskType}</h6>
      <div className="cardWrapper">
        {tasks?.map((card, index) => (
          <div
            key={index}
            className="card border-0 m-2"
            style={{ backgroundColor: `${bgColorType[card.taskPriority]}` }}
          >
            <div className="card-data-wrapper">
              <h6>{card.taskTitle}</h6>
              <p>{card.taskDetail}</p>
            </div>
            <div className="card-footer">
              <span className={`status text-white rounded-5 w-25 text-center fw-bold py-1 bg-${priorityColor[card.taskPriority]}`}>
                {card.taskPriority}
              </span>
              <span className="card-icon-wrapper">
                {
                  taskType!=="Completed" && (
                    <span className="edit-task" onClick={()=>{showUpdateModal(index,taskType);}}>
                      <svg
                        xmlns="http://www.w3.org/2000/svg"
                        width="16"
                        height="16"
                        fill="currentColor"
                        className="bi bi-pencil-fill"
                        viewBox="0 0 16 16"
                      >
                        <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.5.5 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11z" />
                      </svg>
                    </span>

                  )
                }
                <span className="delete-task" onClick={()=>{deleteTask(index,taskType);}}>
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    width="16"
                    height="16"
                    fill="currentColor"
                    className="bi bi-trash3-fill"
                    viewBox="0 0 16 16"
                  >
                    <path d="M11 1.5v1h3.5a.5.5 0 0 1 0 1h-.538l-.853 10.66A2 2 0 0 1 11.115 16h-6.23a2 2 0 0 1-1.994-1.84L2.038 3.5H1.5a.5.5 0 0 1 0-1H5v-1A1.5 1.5 0 0 1 6.5 0h3A1.5 1.5 0 0 1 11 1.5m-5 0v1h4v-1a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5M4.5 5.029l.5 8.5a.5.5 0 1 0 .998-.06l-.5-8.5a.5.5 0 1 0-.998.06m6.53-.528a.5.5 0 0 0-.528.47l-.5 8.5a.5.5 0 0 0 .998.058l.5-8.5a.5.5 0 0 0-.47-.528M8 4.5a.5.5 0 0 0-.5.5v8.5a.5.5 0 0 0 1 0V5a.5.5 0 0 0-.5-.5" />
                  </svg>
                </span>
              </span>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default TaskCards;
