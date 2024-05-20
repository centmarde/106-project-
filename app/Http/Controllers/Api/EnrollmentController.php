<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Enrollment;

class EnrollmentController extends Controller
{
    public function store(Request $request)
    {
        // Validate the request data
        $validatedData = $request->validate([
            'student_id' => 'required|integer|exists:students,id',
            'course_id' => 'required|integer|exists:courses,id',
            // Add more validation rules as necessary
        ]);

        // Create a new enrollment
        $enrollment = Enrollment::create($validatedData);

        // Return a response
        return response()->json([
            'message' => 'Enrollment created successfully',
            'enrollment' => $enrollment,
        ], 201);
    }
}
