<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Enrollment extends Model
{
    use HasFactory;

    protected $table = 'enrollment'; 

    protected $primaryKey = 'id';
    

    protected $fillable = [
        'course_id',
        'student_id',
    ];

    public function student()
{
    return $this->belongsTo(Students::class, 'student_id', 'student_id');
}

public function course()
{
    return $this->belongsTo(Courses::class, 'course_id', 'course_id');
}

}
