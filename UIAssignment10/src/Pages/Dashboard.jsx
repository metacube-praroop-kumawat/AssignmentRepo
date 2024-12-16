import React, { useState, useEffect } from "react";
import Header from "../common/Header";
import Cards from "../Components/TaskManager/DashboardComponents/Cards";
import TaskModal from "../Components/TaskManager/TaskModal";

function Dashboard() {
  const [newTasks, setNewTasks] = useState([
    {
      taskTitle: "Title1",
      taskDetail: "Description of tasks",
      taskStatus: "New",
      taskPriority: "High"
    },
    {
      taskTitle: "Title2",
      taskDetail: "Description of tasks",
      taskStatus: "New",
      taskPriority: "Medium"
    },
    {
      taskTitle: "Title3",
      taskDetail: "Description of tasks",
      taskStatus: "New",
      taskPriority: "Low"
    }
  ]);
  const [inProgressTasks, setInProgressTasks] = useState([
    {
      taskTitle: "Title1",
      taskDetail: "Description of tasks",
      taskStatus: "In Progress",
      taskPriority: "High"
    },
    {
      taskTitle: "Title2",
      taskDetail: "Description of tasks",
      taskStatus: "In Progress",
      taskPriority: "Medium"
    },
    {
      taskTitle: "Title3",
      taskDetail: "Description of tasks",
      taskStatus: "In Progress",
      taskPriority: "Low"
    }
  ]);
  const [completedTasks, setCompletedTasks] = useState([
    {
      taskTitle: "Title1",
      taskDetail: "Description of tasks",
      taskStatus: "Completed",
      taskPriority: "High"
    },
    {
      taskTitle: "Title2",
      taskDetail: "Description of tasks",
      taskStatus: "Completed",
      taskPriority: "Medium"
    },
    {
      taskTitle: "Title3",
      taskDetail: "Description of tasks",
      taskStatus: "Completed",
      taskPriority: "Low"
    }
  ]);

  const [updateModule, setUpdateModule] = useState({
    isUpdating: false,
    updateTaskIndex: null,
    updateTask: null,
    updateTasks: newTasks,
    setUpdateTasks: setNewTasks
  });

  //modal control
  const [show, setShow] = useState(false);

  const handleClose = () => {
    setShow(false);
  };

  const showNewTaskModal = () => {
    setShow(true);
    setUpdateModule({
      ...updateModule,
      isUpdating: false,
    });
  };
  
  const showUpdateModal = (index,taskType) => {
    setShow(true);
    updateModule.isUpdating = true;
    updateModule.updateTaskIndex = index;
    updateModule.updateTask = taskType==="New"? newTasks[index] : inProgressTasks[index];
    updateModule.updateTasks = taskType==="New"? newTasks: inProgressTasks;
    updateModule.setUpdateTasks = taskType==="New"? setNewTasks: setInProgressTasks;
    setUpdateModule({
      ...updateModule
    });
  };

  const deleteTask = (index, taskType) => {
    if(taskType === "New"){
      setNewTasks(newTasks.filter((task, taskIndex)=>{
        if(index !== taskIndex){
          return task;
        }
      }))
    }
    else if(taskType === "In Progress"){
      setInProgressTasks(inProgressTasks.filter((task, taskIndex)=>{
        if(index !== taskIndex){
          return task;
        }
      }))
    }
    else if(taskType === "Completed"){
      setCompletedTasks(completedTasks.filter((task, taskIndex)=>{
        if(index !== taskIndex){
          return task;
        }
      }))
    }
  }

  useEffect(()=>{
    if(!updateModule.isUpdating){
      updateModule.isUpdating = false;
      updateModule.updateTaskIndex = null;
      updateModule.updateTask = null;
      updateModule.updateTasks = newTasks;
      updateModule.setUpdateTasks = setNewTasks;
      setUpdateModule({
        ...updateModule
      })
    }
  }, [updateModule.isUpdating, newTasks])

  return (
    <div className="todoContainer">
      <Header handleShow={showNewTaskModal} />
      <TaskModal
        show={show}
        updateModule={updateModule}
        handleClose={handleClose}
        newTasks={newTasks}
        setNewTasks={setNewTasks}
        inProgressTasks={inProgressTasks}
        setInProgressTasks={setInProgressTasks}
        completedTasks={completedTasks}
        setCompletedTasks={setCompletedTasks}
      />
      <Cards
        newTasks={newTasks} 
        inProgressTasks = {inProgressTasks}
        completedTasks = {completedTasks} 
        showUpdateModal = {showUpdateModal}
        deleteTask = {deleteTask}
      />
    </div>
  );
}

export default Dashboard;
