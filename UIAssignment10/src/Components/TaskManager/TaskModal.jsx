import React, { useState, useEffect } from "react";
import Button from "react-bootstrap/Button";
import Modal from "react-bootstrap/Modal";
import Form from "react-bootstrap/Form";

function TaskModal({
  show,
  handleClose,
  updateModule,
  newTasks,
  setNewTasks,
  inProgressTasks,
  setInProgressTasks,
  completedTasks,
  setCompletedTasks,
}) {
  const [currentTask, setCurrentTask] = useState({
    taskTitle: "",
    taskDetail: "",
    taskStatus: "New",
    taskPriority: "High",
    createdAt: "",
    completedAt: "",
  });

  const resetForm = () => {
    setCurrentTask({
      taskTitle: "",
      taskDetail: "",
      taskStatus: "New",
      taskPriority: "High",
      createdAt: "",
      completedAt: "",
    });
  };

  const addTask = (e) => {
    e.preventDefault();
    if (currentTask.taskTitle && currentTask.taskDetail) {
      const newTask = {
        taskTitle: currentTask.taskTitle,
        taskDetail: currentTask.taskDetail,
        taskStatus: currentTask.taskStatus,
        taskPriority: currentTask.taskPriority,
        createdAt: new Date().toLocaleString(),
        completedAt: currentTask.completedAt,
      };
      updateModule.setUpdateTasks([...updateModule.updateTasks, newTask]);
    }
    resetForm();
    handleClose();
  };

  const updateTask = (e) => {
    e.preventDefault();
    if (currentTask.taskTitle && currentTask.taskDetail) {
      const newTask = {
        taskTitle: currentTask.taskTitle,
        taskDetail: currentTask.taskDetail,
        taskStatus: currentTask.taskStatus,
        taskPriority: currentTask.taskPriority,
        createdAt: currentTask.createdAt,
        completedAt: currentTask.completedAt,
      };
      if(currentTask.taskStatus != updateModule.updateTask.taskStatus){
        //remove the task from current status array
        updateModule.setUpdateTasks((updateModule.updateTasks).filter((task, index)=>{
          if(index !== updateModule.updateTaskIndex){
            return task;
          }
        }));
        // add the task to new status array
        if(newTask.taskStatus === "New"){
          setNewTasks([...newTasks, newTask]);
        }else if(newTask.taskStatus === "In Progress"){
          setInProgressTasks([...inProgressTasks, newTask]);
        }else if(newTask.taskStatus === "Completed"){
          newTask.taskStatus = new Date().toLocaleString();
          setCompletedTasks([...completedTasks, newTask]);
        }
      }else{
        updateModule.setUpdateTasks((updateModule.updateTasks).map((task, index)=>{
            if(index === updateModule.updateTaskIndex){
              return newTask;
            }else{
              return task;
            }
        }));
      }
      resetForm();
      handleClose();
    }
  };

  useEffect(() => {
    if (!updateModule.isUpdating) {
      setCurrentTask({
        taskTitle: "",
        taskDetail: "",
        taskStatus: "New",
        taskPriority: "High",
        createdAt: "",
        completedAt: "",
      });
    } else {
      const updateTask = updateModule.updateTasks[updateModule.updateTaskIndex];
      setCurrentTask({
        taskTitle: updateTask.taskTitle,
        taskDetail: updateTask.taskDetail,
        taskStatus: updateTask.taskStatus,
        taskPriority: updateTask.taskPriority,
        createdAt: updateTask.createdAt,
        completedAt: updateTask.completedAt,
      });
    }
  }, [updateModule]);

  return (
    <Modal show={show} onHide={handleClose}>
      <Form>
        <Modal.Header closeButton>
          {!updateModule.isUpdating ? (
            <Modal.Title>New Task</Modal.Title>
          ) : (
            <Modal.Title>Update Task</Modal.Title>
          )}
        </Modal.Header>
        <Modal.Body>
          <Form.Group className="mb-3" controlId="formTaskTitle">
            <Form.Label>Task Title</Form.Label>
            <Form.Control
              type="text"
              placeholder="Enter Title"
              onChange={(e) => {
                setCurrentTask({ ...currentTask, taskTitle: e.target.value });
              }}
              value={currentTask.taskTitle}
            />
          </Form.Group>

          <Form.Group className="mb-3" controlId="formTaskDescription">
            <Form.Label>Task Description</Form.Label>
            <Form.Control
              as="textarea"
              rows={3}
              placeholder="Enter Task Description"
              onChange={(e) => {
                setCurrentTask({ ...currentTask, taskDetail: e.target.value });
              }}
              value={currentTask.taskDetail}
            />
          </Form.Group>
          <Form.Group className="mb-3" controlId="formTaskStatus">
            <Form.Label>Task Status</Form.Label>
            {!updateModule.isUpdating ? (
              <Form.Control
                type="text"
                placeholder="Task Status"
                defaultValue={"New"}
                readOnly
              />
            ) : (
              <Form.Select
                aria-label="tasks priority"
                value={currentTask.taskStatus}
                onChange={(e) =>
                  setCurrentTask({ ...currentTask, taskStatus: e.target.value })
                }
              >
                <option value="New">New</option>
                <option value="In Progress">In Progress</option>
                <option value="Completed">Completed</option>
              </Form.Select>
            )}
          </Form.Group>
          <Form.Group className="mb-3" controlId="formTaskPriority">
            <Form.Label>Task Priority</Form.Label>
            <Form.Select
              aria-label="tasks priority"
              value={currentTask.taskPriority}
              onChange={(e) =>
                setCurrentTask({ ...currentTask, taskPriority: e.target.value })
              }
            >
              <option value="High">High</option>
              <option value="Medium">Low</option>
              <option value="Low">Medium</option>
            </Form.Select>
          </Form.Group>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
          {!updateModule.isUpdating ? (
            <Button variant="primary" type="submit" onClick={(e) => addTask(e)}>
              Add Task
            </Button>
          ) : (
            <Button variant="primary" type="submit" onClick={(e) => updateTask(e)}>
              Update Task
            </Button>
          )}
        </Modal.Footer>
      </Form>
    </Modal>
  );
}

export default TaskModal;
