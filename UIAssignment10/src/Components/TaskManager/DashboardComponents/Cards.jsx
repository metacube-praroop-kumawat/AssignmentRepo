import React from "react";
import TaskCards from "../CardsComponents/TaskCards";

function Cards({newTasks, inProgressTasks, completedTasks, showUpdateModal, deleteTask}) {

  return (
    <div className="todoCards">
      <TaskCards tasks={newTasks} taskType={"New"} showUpdateModal={showUpdateModal} deleteTask={deleteTask}  />
      <TaskCards tasks={inProgressTasks} taskType={"In Progress"} showUpdateModal={showUpdateModal} deleteTask={deleteTask} />
      <TaskCards tasks={completedTasks} taskType={"Completed"} deleteTask={deleteTask} />
    </div>
  );
}

export default Cards;
