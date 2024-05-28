import { Module } from "@nestjs/common";
import { TypeOrmModule } from '@nestjs/typeorm';
import { AnswerMapper, AnswerProfile } from "../mappers/index.mapper";
import { ContextInformationUtil } from "../utils/context.information.util";
import { BusinessResponse } from "src/dtos/response/businnes.response";
import { AnswerDocument } from "src/api/documents/Answer.document";
import { AnswerController } from "src/api/controllers/Answer.controller";
import { AnswerService } from "src/api/services/Answer.service";
import { AnswerRepository } from "src/api/documents/contracts/Answer.repository";

@Module({
    imports: [
        TypeOrmModule.forFeature([AnswerDocument])
    ],
    controllers: [AnswerController],
    providers: [AnswerService, AnswerMapper, AnswerProfile, AnswerRepository, ContextInformationUtil, BusinessResponse]
})
export class AnswerModule { }