import React from "react";
import "../App.css";
function Header({ handleShow }) {
  return (
    <div className="header shadow-lg">
      <span>My Task Tracker</span>
      <button onClick={handleShow}>New Task</button>
    </div>
  );
}

export default Header;
