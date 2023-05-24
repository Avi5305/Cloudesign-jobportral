import React, { useState } from 'react';
import { Link } from 'react-router-dom';

export default function JobSeekersHome() {
  const [selectedJob, setSelectedJob] = useState(null);

  const [jobsData, setJobsData] = useState([]);
  var index =0;
  const fetchData = () => {
    fetch('http://localhost:8080/positions')
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
        Show Available Jobs
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
              
              <td><a href={`/ApplicationForm/${val.pid}`} className="btn btn-primary">Apply</a></td>

            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
