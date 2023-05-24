import React, { useState } from 'react';

export default function RecruitersHome() {
  const [jobsData, setJobsData] = useState([]);
  console.log(localStorage.getItem('recruiter_id'));
  const fetchData = () => {
    fetch('http://localhost:8080/mypositions/'+JSON.parse(localStorage.getItem("loggeduser")).recruiter_id)
      .then(resp => resp.json())
      .then(data => {
        if (data.length > 0) {
          setJobsData(data);
        }
      })
      .catch(error => console.log(error));
  };

  return (
    <div>
      <button id="btn" onClick={fetchData}>
        Show Uploaded Jobs
      </button>
      <table className="table">
        <thead>
          <tr>
            <th>Position</th>
            <th>Company Name</th>
            <th>Salary</th>
            <th>Experience</th>
            <th>Location</th>
            <th></th>
          </tr>
        </thead>
        <tbody id="result">
          {jobsData.map((val, index) => (
            <tr key={index}>
              <td>{val.name}</td>
              <td>{val.company}</td>
              <td>{val.salary}</td>
              <td>{val.experience}</td>
              <td>{val.location}</td>
              <td></td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
