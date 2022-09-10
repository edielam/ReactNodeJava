import express from 'express'
import ctrlUser from '../controllers/user.controller'

const router = express.Router()

router.route('/api/users')
    .get(ctrlUser.list)
    .post(ctrlUser.create)
router.route('/api/users/:userId')
    .get(ctrlUser.read)
    .put(ctrlUser.update)
    .delete(ctrlUser.remove)
router.param('userId', ctrlUser.userByID)

export default router