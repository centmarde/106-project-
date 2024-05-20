<!-- dashboard.blade.php -->

@extends('layouts.app')

@section('content')
    <div class="container">
       
        <table class="table">
        <h2 id="h2">List of all Students</h2>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Contact Number</th>
                    
                </tr>
            </thead>
            <tbody>
                @foreach ($students as $students)
                    <tr>
                        <td>{{ $students->student_id }}</td>
                        <td>{{ $students->name }}</td>
                        <td>{{ $students->address }}</td>
                        <td>{{ $students->contact_number }}</td>
                    
                    </tr>
                @endforeach
            </tbody>
           
        </table>
    </div>
    @endsection

    @section('content2')
     <div class="container">
       
        <table class="table">
        <h2 id="h2">Courses Offered</h2>
            <thead>
                <tr>
                    <th>Courese Id</th>
                    
                    <th>Course Title</th>
                    <th>Course Description</th>
                    
                </tr>
            </thead>
            <tbody>
                @foreach ($courses as $courses)
                    <tr>
                        <td>{{ $courses->course_id }}</td>
                       
                        <td>{{ $courses->course_title }}</td>
                        <td>{{ $courses->course_description }}</td>
                    
                    </tr>
                @endforeach
            </tbody>
           
        </table>
    </div>
    @endsection


    @section('content3')
     <div class="container">
       
        <table class="table">
        <h2 id="h2">Already Enrolled</h2>
            <thead>
                <tr>
                    <th>Course Id</th>
                    <th>Student Id</th>
                    <th>Name</th>
                    <th>Title</th>
                    
                </tr>
            </thead>
            <tbody>
                @foreach ($enrollment as $enrollment)
                    <tr>
                        <td>{{ $enrollment->course->course_id }}</td>
                        <td>{{ $enrollment->student->student_id }}</td>
                        <td>{{ $enrollment->student->name }}</td>
                        <td>{{ $enrollment->course->course_title }}</td>
                       
                        
                    
                    </tr>
                @endforeach
            </tbody>
           
        </table>
    </div>
    @endsection
