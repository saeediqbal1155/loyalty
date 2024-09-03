<?php

namespace App\Models;

use CodeIgniter\Model;

class ErrorModel extends Model
{
    protected $table = 'errors';
    protected $primaryKey = 'id';
    protected $allowedFields = ['message', 'timestamp'];
    protected $useTimestamps = false;
}