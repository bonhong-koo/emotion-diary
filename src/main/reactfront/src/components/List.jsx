import Button from "./Button";
import { useNavigate } from "react-router-dom";
import DiaryItem from "./DiaryItem";
import "./List.css";
import { useState } from "react";
const List = ({ monthlyData }) => {
  const nav = useNavigate();
  const [sortType, setSortType] = useState("latest");

  const onChangeSortType = (e) => {
    setSortType(e.target.value);
  };

  const getSortedData = () => {
    return monthlyData.toSorted((a, b) => {
      if (sortType === "oldest") {
        return Number(a.date) - Number(b.date);
      } else {
        return Number(b.date) - Number(a.date);
      }
    });
  };

  const sortedData = getSortedData();

  return (
    <div className="List">
      <div className="menu_bar">
        <select onChange={onChangeSortType}>
          <option value={"latest"}>최신순</option>
          <option value={"oldest"}>오래된 순</option>
        </select>
        <Button
          onClick={() => nav("/new")}
          text={"새 일기 쓰기"}
          type={"POSITIVE"}
        />
      </div>
      <div className="list_wrapper">
        {sortedData.map((item) => (
          <DiaryItem key={item.no} {...item} />
        ))}
      </div>
    </div>
  );
};

export default List;
