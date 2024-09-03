<?php

namespace App\Models;

use CodeIgniter\Model;

class UserModel extends Model
{
    protected $table = 'users';
    protected $primaryKey = 'id';
    protected $allowedFields = ['username', 'contact_type', 'contact_info', 'timestamp'];
    protected $useTimestamps = false;
}