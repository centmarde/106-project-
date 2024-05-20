<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Courses extends Model
{
    use HasFactory;

    protected $table = 'courses'; 

    protected $primaryKey = 'course_id';
    protected $keyType = 'string';
    public $incrementing = false;

    protected $fillable = [
        'course_id',
        'student_id',
        'course_title',
        'course_description',
    ];
}
