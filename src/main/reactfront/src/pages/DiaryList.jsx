import { useEffect, useState } from "react";
import Button from "../components/Button";
import Header from "../components/Header";
import List from "../components/List";
import axios from "axios";

const getMonthlyData = (pivotDate, data) => {
  const beginTime = new Date(
    pivotDate.getFullYear(),
    pivotDate.getMonth(),
    1,
    0,
    0,
    0
  );
  const endTime = new Date(
    pivotDate.getFullYear(),
    pivotDate.getMonth() + 1,
    0,
    23,
    59,
    59
  );

  return data.filter((item) => {
    return beginTime <= item.date && endTime >= item.date;
  });
};
const DiaryList = () => {
  const [data, setData] = useState([]);
  const [pivotDate, setPivotDate] = useState(new Date());

  useEffect(() => {
    axios
      .get("/api/diaryList")
      .then((res) => {
        const converted = res.data.map((item) => ({
          ...item,
          date: new Date(item.date.replace(" ", "T")),
        }));
        setData(converted);
      })
      .catch((err) => {
        alert(err);
      });
  }, []);

  const monthlyData = getMonthlyData(pivotDate, data);

  const onIncreaseMonth = () => {
    setPivotDate(new Date(pivotDate.getFullYear(), pivotDate.getMonth() + 1));
  };
  const onDecreaseMonth = () => {
    setPivotDate(new Date(pivotDate.getFullYear(), pivotDate.getMonth() - 1));
  };
  return (
    <div>
      <Header
        leftChild={<Button text={"<"} onClick={onDecreaseMonth} />}
        rightChild={<Button text={">"} onClick={onIncreaseMonth} />}
        title={`${pivotDate.getFullYear()}년 ${pivotDate.getMonth() + 1}월`}
      />
      <List monthlyData={monthlyData} />
    </div>
  );
};
export default DiaryList;
