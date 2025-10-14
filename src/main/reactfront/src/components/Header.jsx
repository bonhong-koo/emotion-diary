import "./Header.css";
import Button from "./Button";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const Header = ({ leftChild, title, rightChild, logoutButton }) => {
  return (
    <div className="Header">
      <div className="header_left">{leftChild}</div>
      <div className="header_center">{title}</div>
      <div className="header_right">
        <div>{logoutButton}</div>
        <div>{rightChild}</div>
      </div>
    </div>
  );
};

export default Header;
