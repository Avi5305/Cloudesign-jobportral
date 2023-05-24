import React from 'react';
import ReactDOM from 'react-dom/client';
import {createBrowserRouter , RouterProvider} from 'react-router-dom';
import App from './App';
import Login from './components/Login';
import RecruitRegister from './components/RecruitRegister';
import JobSeekerRegister from './components/JobSeekerRegister';
import SelectRole from './components/SelectRole';
import JobSeekersHome from './components/JobSeekersHome';
import RecruitersHome from './components/RecruitersHome';
import ApplicationForm from './components/ApplicationForm';



const router = createBrowserRouter([
  {
    path:'/',
    element:<App/>,
    children:[
      {
        path:'/',
        element:<Login/>
      },
      {
        path:'/Login',
        element:<Login/>
      },
      {
        path:'/RecruiterRegister',
        element:<RecruitRegister/>

      },
      {
        path:'/RecruiterHome',
        element:<RecruitersHome/>

      },
      {
        path:'/SelectRole',
        element:<SelectRole/>
      },
      {
        path:'/JobSeekerRegister',
        element:<JobSeekerRegister/>
      },
      {
        path:'/JobSeekerHome',
        element:<JobSeekersHome/>
      },
      {
        path:'/ApplicationForm/:pid',
        element:<ApplicationForm/>
      }

    ]
  }
])

ReactDOM.createRoot(document.getElementById('root')).render(
  <RouterProvider router={router}/>
)
