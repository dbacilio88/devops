import { Module } from "@nestjs/common";
import { TypeOrmModule } from '@nestjs/typeorm';
import { QuestionMapper, QuestionProfile } from "../mappers/index.mapper";
import { ContextInformationUtil } from "../utils/context.information.util";
import { BusinessResponse } from "src/dtos/response/businnes.response";
import { QuestionDocument } from "src/api/documents/Question.document";
import { QuestionController } from "src/api/controllers/Question.controller";
import { QuestionService } from "src/api/services/Question.service";
import { QuestionRepository } from "src/api/documents/contracts/Question.repository";

@Module({
    imports: [
        TypeOrmModule.forFeature([QuestionDocument])
    ],
    controllers: [QuestionController],
    providers: [QuestionService, QuestionMapper, QuestionProfile, QuestionRepository, ContextInformationUtil, BusinessResponse]
})
export class QuestionModule { }