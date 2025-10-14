import "./Editor.css";
import { emotionList } from "../util/constants";
import Button from "./Button";
import { useNavigate } from "react-router-dom";
import EmotionItem from "./EmotionItem";
import { useEffect, useState } from "react";

const getStringedDate = (targetDate) => {
  //날짜 -> YYYY-MM-DD 스트링으로
  let year = targetDate.getFullYear();
  let month = targetDate.getMonth() + 1;
  let date = targetDate.getDate();

  if (month < 10) {
    month = `0${month}`;
  }
  if (date < 10) {
    date = `0${date}`;
  }
  return `${year}-${month}-${date}`;
};

const Editor = ({ onSubmit, data }) => {
  const nav = useNavigate();
  const [input, setInput] = useState({
    date: new Date(),
    emotion: 3,
    title: "",
    content: "",
  });
  useEffect(() => {
    if (data) {
      setInput(data);
    }
  }, [data]);

  const onChangeInput = (e) => {
    let id = e.target.id;
    let value = e.target.value;

    if (id === "date") {
      value = new Date(value);
    }

    setInput({
      ...input,
      [id]: value,
    });
  };
  const onClickSubmitButton = () => {
    const value = {
      ...input,
      date: getStringedDate(input.date),
    };

    if (input.title === "") {
      alert("제목을 입력하세요!");
      document.getElementById("title").focus();
      return;
    }

    if (input.content === "") {
      alert("내용을 입력하세요!");
      document.getElementById("content").focus();
      return;
    }

    onSubmit(value);
  };

  return (
    <div className="Editor">
      <section className="date_section">
        <h4>날짜</h4>
        <input
          type="date"
          id="date"
          onChange={onChangeInput}
          value={getStringedDate(input.date)}
        />
      </section>
      <section className="emotion_section">
        <h4>오늘의 감정</h4>
        <div className="emotion_list_wrapper">
          {emotionList.map((item) => (
            <EmotionItem
              onClick={() =>
                onChangeInput({
                  target: {
                    id: "emotion",
                    value: item.emotion,
                  },
                })
              }
              key={item.emotion}
              {...item}
              isSelected={item.emotion === input.emotion}
            />
          ))}
        </div>
      </section>
      <section className="title_section">
        <h4>제목</h4>
        <input
          type="text"
          id="title"
          onChange={onChangeInput}
          value={input.title}
          maxLength={40}
        />
      </section>
      <section className="content_section">
        <h4>오늘의 일기</h4>
        <textarea
          id="content"
          placeholder="오늘은 어땠나요?"
          value={input.content}
          onChange={onChangeInput}
          maxLength={300}
        />
      </section>
      <section className="button_section">
        <Button onClick={() => nav(-1)} text={"취소하기"} />
        <Button
          text={"작성하기"}
          type={"POSITIVE"}
          onClick={onClickSubmitButton}
        />
      </section>
    </div>
  );
};

export default Editor;
